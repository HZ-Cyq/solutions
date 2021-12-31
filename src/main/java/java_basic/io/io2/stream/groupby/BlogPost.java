package java_basic.io.io2.stream.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenyuqun
 * @date 2021/12/17 11:11 上午
 */
public class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }

    public static void main(String[] args) {
        List<BlogPost> posts = new ArrayList<>();
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.QUIDE, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.REBIEW, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        posts.add(new BlogPost("aa","bb",BlogPostType.NEWS, 1));
        Map<BlogPostType, List<BlogPost>> collect = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        for (Map.Entry<BlogPostType, List<BlogPost>> entry : collect.entrySet()) {
            System.out.println("key:" + entry.getKey());
            for (BlogPost blogPost : entry.getValue()) {
                System.out.println(blogPost);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", likes=" + likes +
                '}';
    }
}
