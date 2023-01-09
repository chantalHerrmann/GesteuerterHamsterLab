import de.thm.oop.chat.base.server.BasicTHMChatServer;

public class HamsterUser extends Receiver {
    new CommandHandler ch;

    public HamsterUser(String name, BasicTHMChatServer s){
        super(name);
        ch = new CommandHandler(s);
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
