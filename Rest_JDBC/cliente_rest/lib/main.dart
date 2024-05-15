import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(const MaterialApp(
    home: ClientRest(),
  ));
}

class ClientRest extends StatefulWidget {
  const ClientRest({super.key});

  @override
  State<ClientRest> createState() => _ClientRestState();
}

class _ClientRestState extends State<ClientRest> {
  final TextEditingController _nameController = TextEditingController();

  Future<void> _sendData() async {
    final String name = _nameController.text;

    final response = await http.post(
      Uri.parse('http://192.168.227.192:3000/user'),
      headers: {
        'Content-Type': 'application/json',
        'token': '1234', // Asegúrate de incluir el token si es necesario
      },
      body: jsonEncode({
        'data': {'nombre': name}
      }), // Envia un objeto 'user' con 'nombre'
    );

    if (response.statusCode == 200) {
      // Solicitud exitosa
      print('Solicitud exitosa: ${response.body}');
    } else {
      // Error en la solicitud
      print('Error en la solicitud: ${response.statusCode}');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Directionality(
      textDirection: TextDirection.ltr, // Dirección de izquierda a derecha
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Enviar Datos'),
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              TextField(
                controller: _nameController,
                decoration: const InputDecoration(labelText: 'Nombre'),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _sendData,
                child: const Text('Enviar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
