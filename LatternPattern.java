//practicing with calling functions
public class LatternPattern {

    public static void main(String[] args) {
        laterns();
        System.out.println();
        laterns();
        laternsStars();
        laternsBot();
        laterns();
        System.out.println();
        laterns();
        laternsTop();
        laternsStars();
        laternsStars();
        laternsTop();
        laternsTop();
    }
    public static void laternsTop() {
        System.out.println("    *****");
    }
    public static void laternsMid() {
        System.out.println("  *********");
    }
    public static void laternsBot() {
        System.out.println("*************");
    }
    public static void laterns() {
        laternsTop();
        laternsMid();
        laternsBot();
    }
    public static void laternsStars() {
        System.out.println("* | | | | | *");
    }
}
