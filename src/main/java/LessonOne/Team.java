package LessonOne;

public class Team {
    public static void main(String[] args) {
        Member[] members = {
                new Member("GeekBrains", "Максим", 500, 400, 2),
                new Member("GeekBrains", "Вовочка", 300, 150, 3),
                new Member("GeekBrains", "Мария", 350, 300, 4),
                new Member("GeekBrains", "Виктория", 550, 500, 1)};


        Course c = new Course(500, 300, 2 );
        c.showMaxRunInfo();
        c.showMaxSwimInfo();
        c.showMaxJumpInfo();



        for (Member Member : members) {
            Member.MembersMaxRun(c);


        }
        for (Member Member : members) {
            Member.MembersMaxSwim(c);


        }
        for (Member Member : members) {
            Member.MembersMaxJump(c);

        }
    }
}






