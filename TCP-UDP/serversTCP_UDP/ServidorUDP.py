import socket
import threading

def handle_client(client_socket, client_address):
    while True:
        data, _ = client_socket.recvfrom(1024)
        if not data:
            break
        print('Mensaje recibido del cliente {}:{}: {}'.format(client_address[0], client_address[1], data.decode()))
        response = "Mensaje recibido por el servidor: {}".format(data.decode())
        client_socket.sendto(response.encode(), client_address)

def main():
    # Creamos un socket UDP/IP
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    # Enlace del socket a una dirección y puerto
    server_address = ('192.168.131.95', 12346)
    print('Iniciando en {} puerto {}'.format(*server_address))
    server_socket.bind(server_address)

    print('Esperando mensajes entrantes...')

    while True:
        # Esperando una conexión
        data, client_address = server_socket.recvfrom(1024)

        # Iniciamos un hilo para manejar la conexión con el cliente
        client_thread = threading.Thread(target=handle_client, args=(server_socket, client_address))
        client_thread.start()

if __name__ == "__main__":
    main()