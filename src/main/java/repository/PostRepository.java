package repository;

import model.Post;

import exception.NotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {

    private final Map<Long, Post> posts = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Post> all() {
        return List.copyOf(posts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(posts.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            long newId = counter.incrementAndGet();
            post.setId(newId);
        } else {
            if (!posts.containsKey(post.getId())) {
                throw new NotFoundException("Post not found with id: " + post.getId());
            }
        }
        posts.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        if (posts.remove(id) == null) {
            throw new NotFoundException("Post not found with id: " + id);
        }
    }
}