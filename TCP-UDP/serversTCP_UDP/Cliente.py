import socket

def main():
    # Creamos un socket TCP/IP
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Conectamos el socket al servidor
    server_address = ('localhost', 12345)
    print('Conectando a {} puerto {}'.format(*server_address))
    client_socket.connect(server_address)

    try:
        while True:
            # Solicitar mensaje al usuario
            message = input("Ingrese su mensaje (escriba 'exit' para salir): ")
            if message == 'exit':
                break

            # Enviamos datos al servidor
            print('Enviando:', message)
            client_socket.sendall(message.encode())

            # Esperando una respuesta
            data = client_socket.recv(1024)
            print('Recibido:', data.decode())

    finally:
        # Cerrando el socket
        print('Cerrando el socket')
        client_socket.close()

if __name__ == "__main__":
    main()