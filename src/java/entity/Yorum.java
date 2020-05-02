
package entity;

/**
 *
 * @author mehmet
 */
public class Yorum {
    private int fkmusabaka;
    private int fkuye;
    private String yorum;

    public Yorum() {
    }
    
    public int getFkmusabaka() {
        return fkmusabaka;
    }

    public void setFkmusabaka(int fkmusabaka) {
        this.fkmusabaka = fkmusabaka;
    }

    public int getFkuye() {
        return fkuye;
    }

    public void setFkuye(int fkuye) {
        this.fkuye = fkuye;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }
    
    
}
