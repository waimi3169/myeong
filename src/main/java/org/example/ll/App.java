package org.example.ll;


import org.example.ll.system.controller.SystemController;
import org.example.ll.wiseSaying.controller.WiseSayingController;
import org.example.ll.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            String a = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(a);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;

            }
        }
    }
}
