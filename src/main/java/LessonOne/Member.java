package LessonOne;

public class Member {
    String teamName;
    String teamMembers;
    int maxRun;
    int maxSwim;
    int maxJump;




    public Member(String teamName, String teamMembers, int maxRun, int maxSwim, int maxJump) {

        this.teamName = teamName;
        this.teamMembers = teamMembers;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    public void MembersMaxRun(Course c) {
        if (maxRun >= c.maxRunDistance) {
            System.out.println(teamMembers + " прошёл (ла) тест, так как пробежал (ла) " + maxRun + " метров от макимальной дистанции");

        }
        else {
            System.out.println(teamMembers + " провалил (ла) тест, так не как пробежал (ла) " + maxRun + " метров от макимальной дистанции");
        }
    }

    public void MembersMaxSwim(Course c) {
        if (maxSwim >= c.maxSwimDistance) {
            System.out.println(teamMembers + " прошёл (ла) тест так как проплыл (ла) " + maxSwim + " метров от макимальной дистанции");

        }

        else {
            System.out.println(teamMembers + " провалил (ла) тест, так как не проплыл (ла) " + maxSwim + " метров от макимальной  дистанции");
        }
    }

    public void MembersMaxJump (Course c) {
        if (maxJump >= c.maxJumpLength) {
            System.out.println(teamMembers + " прошёл (ла) тест так как прыгнул (ла) " + maxJump + " метров от макимальной дистанции");

        }

        else {
            System.out.println(teamMembers + " провалил (ла) тест, так как не прыгнул (ла) " + maxJump + " метров от макимальной  дистанции");
        }
    }
}



