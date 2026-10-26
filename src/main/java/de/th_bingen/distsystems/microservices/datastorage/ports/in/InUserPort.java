package de.th_bingen.distsystems.microservices.datastorage.ports.in;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.UserDTO;
import de.th_bingen.distsystems.microservices.datastorage.services.User;

import java.util.UUID;

public interface InUserPort {
    UserDTO getUser(UUID uuid);
    UUID postUser(String firstName, String lastName);
    boolean deleteUser(UUID uuid);
}
