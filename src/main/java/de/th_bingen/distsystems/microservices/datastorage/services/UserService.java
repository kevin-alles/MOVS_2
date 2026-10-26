package de.th_bingen.distsystems.microservices.datastorage.services;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.UserDTO;
import de.th_bingen.distsystems.microservices.datastorage.ports.in.InUserPort;
import de.th_bingen.distsystems.microservices.datastorage.ports.out.OutUserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements InUserPort {
    final OutUserPort outUserPort;

    @Autowired
    public UserService(OutUserPort outUserPort) {
        this.outUserPort = outUserPort;
    }

    @Override
    public UserDTO getUser(UUID uuid) {
        User user = outUserPort.getUser(uuid);
        if (user == null)
            return null;
        return new UserDTO(user.firstName(), user.lastName());
    }

    @Override
    public UUID postUser(String firstName, String lastName) {
        return outUserPort.saveUser(new User(UUID.randomUUID(), firstName, lastName));
    }

    @Override
    public boolean deleteUser(UUID uuid) {
        return outUserPort.deleteUser(uuid);
    }
}
