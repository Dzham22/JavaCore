package LessonOne;

    public class Course {
        int maxRunDistance;
        int maxSwimDistance;
        int maxJumpLength;

        public Course(int maxRunDistance, int maxSwimDistance, int maxJumpLength) {
            this.maxRunDistance = maxRunDistance;
            this.maxSwimDistance = maxSwimDistance;
            this.maxJumpLength = maxJumpLength;

        }


        public void showMaxRunInfo() {
            System.out.println("Максимальная дистанция для бега " + maxRunDistance + " метров");
        }

        public void showMaxSwimInfo() {
            System.out.println("Максимальная дистанция для плавания " + maxSwimDistance + " метров");
        }

        public void showMaxJumpInfo() {
            System.out.println("Максимальная высота прыжка " + maxJumpLength + " метра");
        }

    }
