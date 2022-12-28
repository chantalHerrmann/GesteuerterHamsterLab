public class HamsterUser extends Receiver {

    public HamsterUser(String name){
        super(name);
    }

    public void vor() {
        execute("msg" + getName() + "vor");
    }

    public void linksUm() {
        execute("msg" + getName() + "linksUm");
    }

    public void nimm() {
        execute("msg" + getName() + "nimm");
    }

}
