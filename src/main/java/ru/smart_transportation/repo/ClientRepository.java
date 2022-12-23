package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smart_transportation.entity.AppUser;
import ru.smart_transportation.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Transactional
    @Modifying
    @Query("update Client c set c.companyName = ?1, c.phoneNumber = ?2 where c.id = ?3")
    void updateCompanyNameAndPhoneNumberById(String companyName, String phoneNumber, Integer id);
    Client findClientByAppUser(AppUser appUser);
}

