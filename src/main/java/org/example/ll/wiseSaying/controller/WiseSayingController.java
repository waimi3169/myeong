package org.example.ll.wiseSaying.controller;

import org.example.ll.Container;
import org.example.ll.Rq;
import org.example.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    private long lastid;
    private List<WiseSaying> wiseSayings;

    public WiseSayingController() {
        lastid = 0;
        wiseSayings = new ArrayList<>();
    }
    private WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId()==id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void write() {
        long id = lastid + 1;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        WiseSaying wiseSaying= new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastid = id;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (int i = wiseSayings.size() - 1; i>=0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(),wiseSaying.getContent(),wiseSaying.getAuthor());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id",-1);

        if(id==-1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify(Rq rq) {int id = rq.getIntParam("id",-1);

        if(id==-1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}
