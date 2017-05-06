import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Remote(RepositoryRemote.class)
public class RepositoryTestBean implements RepositoryRemote {

    List<Integer> topics;

    @PostConstruct
    public void initializeTopics() {
        topics = new ArrayList<>();
    }

    @Override
    public void addTopic() {
        if (topics.isEmpty()) {
            topics.add(0);
        }
        else {
            topics.add(topics.get(topics.size()-1)+1);
        }
    }

    @Override
    public List<Integer> getTopics() {
        return topics;
    }
}
