package controller;
import dao.PersonDao;
import dao.ProfileDao;
import entity.Person;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean
@SessionScoped

public class PersonController  implements java.io.Serializable {
    
    private PersonDao personDao;
    private Person person;
 
    
    public PersonController() {
        this.personDao = new PersonDao();
        this.person = new Person();
        Person.PersonInstance = this.person;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public String getLogin() throws ClassNotFoundException {
         person.PersonInstance = this.personDao.login(this.person);
        if(person.PersonInstance.getId() != 0){
            return "main";
        }else{        
        return "index";
        }
    }
    
      public String getRegister() throws ClassNotFoundException{
        boolean status = this.personDao.register(this.person);
        if(status){
            return "index";
        }else{        
        return "register";
        }
    }

       public String getPassword() throws ClassNotFoundException{
        boolean status = this.personDao.forgotPassword(this.person);
        if(status){
            return "index";
        }else{        
        return "forgotPassword";
        }
    }
       public String exit(){
           Person.PersonInstance = null;
           Person.UserInstance = null;
           return "index";
       }
    
}
