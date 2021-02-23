package ru.teapot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.teapot.models.Client;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class ClientDAO {

    //private final JdbcTemplate jdbcTemplate;
    private SessionFactory sessionFactory;
    @Autowired
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

//    @Autowired
//    public ClientDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

//    private static int PEOPLE_COUNT;
//    private List<Client> people;
//
//    {
//        people = new ArrayList<>();
//        people.add(new Client(++PEOPLE_COUNT, "Tom", "Cat", "21.01.1991",
//                "паспортные данные", "адресс", "tom@mail.ru", "пароль"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom2", "Cat2", "21.01.1992",
//                "паспортные данные2", "адресс2", "tom2@mail.ru", "пароль2"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom3", "Cat3", "21.01.1993",
//                "паспортные данные3", "адресс3", "tom3@mail.ru", "пароль3"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom4", "Cat4", "21.01.1994",
//                "паспортные данные4", "адресс4", "tom4@mail.ru", "пароль4"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom5", "Cat5", "21.01.1995",
//                "паспортные данные5", "адресс5", "tom5@mail.ru", "пароль5"));
//
//    }
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Client> index() {
        //return jdbcTemplate.query("SELECT * FROM Client", new BeanPropertyRowMapper<>(Client.class));
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client").list();
    }
    @Transactional
    public Client show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Client WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Client.class))
//                .stream().findAny().orElse(null);
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }
    @Transactional
    public void save(Client client) {
//        jdbcTemplate.update("INSERT INTO Client VALUES(1, ?, ?, ?, ?, ?, ?, ?)", client.getName(), client.getSurname(), client.getDateOfBirth(),
//                client.getPassportData(), client.getAddress(), client.getEmail(), client.getPassword());
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }
    @Transactional
    public void update(Client updatedClient) {
//        jdbcTemplate.update("UPDATE Client SET name=?, surname=?, dateOfBirth=?, " +
//                        "passportData=?, address=?, email=?, password=? WHERE id=?",
//                updatedClient.getName(), updatedClient.getSurname(), updatedClient.getDateOfBirth(),
//                updatedClient.getPassportData(), updatedClient.getAddress(), updatedClient.getEmail(), updatedClient.getPassword(), id);
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedClient);
    }
    @Transactional
    public void delete(int id) {
       // jdbcTemplate.update("DELETE FROM Client WHERE id=?", id);
        Session session = sessionFactory.getCurrentSession();
        Client client = session.load(Client.class,id);
        session.delete(client);
        session.flush() ;
    }
}
