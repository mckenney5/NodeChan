import java.util.Random;
import java.util.ArrayList;

/**
 *
 * An entity that represents a single collection of posts or "conversation" on
 * NodeChan.
 * Despite the unfortunate name, this class has nothing to do with
 * multithreading. It's only a collection of posts.
 *
 * This class is a local collection of the posts in a specific thread that the
 * client has received.
 *
 */
public class ChanThread {
  /** Unique thread ID **/
  private String tid;

  /** The title of this thread **/
  private String title;

  /** Storage for all of the posts that have been made in this thread **/
  private ArrayList<ChanPost> posts;

  public ChanThread(String tid, ChanPost firstPost) {
    // generate random 8-character thread ID
    byte[] tid_bytes = new byte[8];
    Random rand = new Random();

    for (int i = 0; i < 8; i++) {
      // generate a random ASCII character from 48 to 122
      tid_bytes[i] = (byte)(rand.nextInt(74) + 48);
    }

    this.tid = new String(tid_bytes);

    this.posts = new ArrayList<ChanPost>();
    this.posts.add(firstPost);

    this.title = firstPost.getTitle();
  }

  /**
   * Add a post to this thread.
   */
  public void addPost(ChanPost post) {
    // TODO: sort by post time!
    this.posts.add(post);
  }


  /*
   * getters
   */
  public String tid() {
    return this.tid;
  }

  public String title() {
    return this.title;
  }

  public int getNumPosts() {
    return this.posts.size();
  }

  /**
   * We want to avoid giving outside classes direct access to the posts
   * ArrayList
   */
  public ChanPost getPost(int i) {
    return this.posts.get(i);
  }
}
