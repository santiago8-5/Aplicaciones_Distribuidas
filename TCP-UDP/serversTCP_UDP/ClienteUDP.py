import socket

def main():
    # Creamos un socket UDP/IP
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)


    # Dirección del servidor
    server_address = ('localhost', 12346)

    try:
        while True:
            # Solicitar mensaje al usuario
            message = input("Ingrese su mensaje (escriba 'exit' para salir): ")
            if message == 'exit':
                break

            # Enviamos datos al servidor
            print('Enviando:', message)
            client_socket.sendto(message.encode(), server_address)

            # No esperamos una respuesta explícita del servidor en UDP
    finally:
        # Cerrando el socket
        print('Cerrando el socket')
        client_socket.close()


if __name__ == "__main__":
    main()