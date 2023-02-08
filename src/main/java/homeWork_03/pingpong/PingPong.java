package homeWork_03.pingpong;

public class PingPong {
  public static void main(String[] args) {
    Object LOCK_OBJECT = new Object();
    Thread ping = new Thread(new PingPongThread(LOCK_OBJECT, "Ping"));
    Thread pong = new Thread(new PingPongThread(LOCK_OBJECT, "Pong"));
    ping.start();
    pong.start();
  }
}