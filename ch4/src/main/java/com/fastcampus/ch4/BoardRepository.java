package com.fastcampus.ch4;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    //SELECT COUNT(*) FROM BOARD WHERE WRITER = writer
    int countAllByWriter(String writer);

    //SELECT * FROM BOARD WHERE WRITER = writer
    List<Board> findByWriter(String writer);

    //SELECT * FROM BOARD WHERE TITLE = title AND WRITER = writer
    List<Board> findByTitleAndWriter(String title, String writer);

    //DELETE FROM BOARD WHERE WRITER = writer
    @Transactional  //delete의 경우, 여러 건을 delete할 수 있기 때문에 Tx처리 필수
    int deleteByWriter(String writer);


}
