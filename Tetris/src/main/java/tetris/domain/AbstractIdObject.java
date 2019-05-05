package tetris.domain;

public abstract class AbstractIdObject {
    
    private Integer id;

    
    public AbstractIdObject(Integer id) {
        this.id = id;
    }

    final public int getId() {
        return id;
    }
    
}