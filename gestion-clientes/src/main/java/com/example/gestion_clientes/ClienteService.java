package com.example.gestionclientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente registrarCliente(String nombre, String direccion, String telefono) {
        Cliente nuevoCliente = new Cliente(nombre, direccion, telefono);
        return clienteRepository.save(nuevoCliente);
    }

    public Cliente actualizarCliente(Long id, String nombre, String direccion, String telefono) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
    }

    public void eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
    }
}
