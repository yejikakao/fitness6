import users.Shop;
import users.Trainee;
import users.Trainer;
import java.util.Scanner; //입력받기위해

public class Main {
    public static void main(String[] args) { //프로그램 실행시 가장 먼저 실행되는 main 메서드
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.println("기본 정보를 입력해주세요.");
        System.out.println("이름: ");
        String name = scanner.nextLine(); //이름 입력받기
        System.out.println("역할 (1: 트레이너, 2: 트레이니, 3: 샵): ");
        int role = scanner.nextInt(); //역할 입력받기
        System.out.println("종목 (1: 헬스, 2: 필라테스): ");
        int category = scanner.nextInt(); //종목 입력받기

        // 입력 후 남아있는 개행 문자 제거
        scanner.nextLine();

        //역할에 따라 다른 질문을 하고 질문에 대답한 내용 출력
        System.out.println("세부 정보를 입력해주세요.");
        switch (role) {	// 조건
            case 1: //트레이너
                System.out.println("성별(M/W): ");
                String gender = scanner.nextLine(); //성별 입력받기
                System.out.println("이력: ");
                String career = scanner.nextLine(); //이력 입력받기
                System.out.println("수업료: ");
                String input = scanner.nextLine(); //수업료 입력받기
                int lessonFee = Integer.parseInt(input); // 문자열을 정수로 변환
                System.out.println("수업가능시간: ");
                String availableTime = scanner.nextLine(); //수업 가능 시간 입력받기
                System.out.println("수업가능지역: ");
                String availableArea = scanner.nextLine(); //수업 가능 지역  입력받기
                Trainer trainer = new Trainer(name,role, category,gender,career, lessonFee,availableTime, availableArea); //입력받은 값 넘겨쥬기
                System.out.println("입력하신 트레이너 정보입니다.");
                trainer.displayInfo();//트레이너 정보 출력
                break;
            case 2: //트레이니
                System.out.print("키(cm): ");
                int height = scanner.nextInt(); // 키 입력받기
                System.out.print("몸무게(kg): ");
                int weight = scanner.nextInt(); // 몸무게 입력받기
                Trainee trainee = new Trainee(name,role, category, height, weight);
                System.out.println("입력하신 트레이니 정보입니다.");
                trainee.displayInfo();//트레이니 정보 출력
                break;
            case 3: //샵
                System.out.print("샵 위치: ");
                String location = scanner.nextLine(); // 샵 위치 입력받기
                System.out.print("대관료: ");
                int rentalFee = scanner.nextInt(); // 대관 료 입력받기
                System.out.print("사용 가능한 시간대: ");
                String availableShopTime = scanner.nextLine(); // 사용 가능한 시간대 입력받기
                Shop shop = new Shop( location, rentalFee, availableShopTime);
                scanner.nextLine();

                System.out.println("입력하신 샵 정보입니다.");
                System.out.println("샵이름: " + name); // 이름 출력
                System.out.println("샵 종목(1: 헬스, 2: 필라테스): " + category); // 이름 출력
                shop.shopInfo();//샵 정보 출력
                break;
            default:
                System.out.println("역할을 선택해주세요.(1: 트레이너, 2: 트레이니, 3: 샵)");
        }
    }
}