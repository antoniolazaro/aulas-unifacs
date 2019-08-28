import java.io.Serializable;

public class Categoria implements Serializable {

	    private Long id;
	    private String content;
	    
	    
	    public Categoria() {
	    }

	    public Categoria(Long id, String content) {
	        super();
	        this.id = id;
	        this.content = content;
	    }
	    
	    public Categoria(Long id) {
	        super();
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	 
}
