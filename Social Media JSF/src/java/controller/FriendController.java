package controller;
import dao.FriendDao;
import dao.ProfileDao;
import entity.Person;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class FriendController implements Serializable{
    
    private Person person;
    private ArrayList<Person> personList;
    private FriendDao friendDao;
    private String personName;
    private ArrayList<Person> myFriendList;
    private ProfileDao profileDao;
    
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public FriendController() {
        this.person = new Person();
        this.personList = new ArrayList<>();
        this.friendDao = new FriendDao();
        this.profileDao = new ProfileDao();
        person=Person.PersonInstance;
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }
  
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Person> getPersonList() throws ClassNotFoundException {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public ArrayList<Person> getMyFriendList() {
        this.myFriendList = this.profileDao.myFriends();
        return myFriendList;
    }

    public void setMyFriendList(ArrayList<Person> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public ProfileDao getProfileDao() {
        return profileDao;
    }

    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }
    
    public void getUsers() throws ClassNotFoundException {
         this.personList = this.getFriendDao().searchUsers(this.personName);
    }
   
    public void Add(Person friend) throws ClassNotFoundException{
        this.friendDao.ADD(friend, person);
        this.myFriendList = this.getProfileDao().myFriends();
    }
    
    public void Delete(Person friend) throws ClassNotFoundException{
        this.friendDao.DELETE(friend, person);
        this.myFriendList = this.getProfileDao().myFriends();
    }
          
 
    public boolean isFriendF(Person person){
      return  !this.getFriendDao().checkFriend(person);
    }
    
    public boolean isFriendUnf(Person person){
       return this.getFriendDao().checkFriend(person);
    }
}
