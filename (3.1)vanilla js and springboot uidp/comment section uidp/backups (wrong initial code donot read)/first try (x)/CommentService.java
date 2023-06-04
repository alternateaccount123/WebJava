import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
    @Autowired
    private CommentRepository commentRepository;


    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
