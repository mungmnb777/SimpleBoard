package project.board.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPaging {

    private int postPerPage = 10;

    private int blockSize = 10;

    private int page = 1;

    private int block = 1;

    private int totalPostCnt;

    private int totalPageCnt;

    private int totalBlockCnt;

    private int startPage = 1;

    private int endPage = 1;

    private int startIndex = 0;

    private int prevBlock;

    private int nextBlock;

    public BoardPaging(int totalPostCnt, int page){

        setPage(page);

        setTotalPostCnt(totalPostCnt);

        setTotalPageCnt((int)Math.ceil(totalPostCnt * 1.0 / postPerPage));

        setTotalBlockCnt((int)Math.ceil(totalPageCnt * 1.0 / blockSize));

        setBlock((int)Math.ceil(page * 1.0 / blockSize));

        setStartPage((block - 1) * blockSize + 1);

        setEndPage(block * blockSize);

        if(endPage > totalPageCnt) { this.endPage = totalPageCnt; }

        setPrevBlock((block * blockSize) - blockSize);

        if(prevBlock < 1) { this.prevBlock = 1; }

        setNextBlock((block * blockSize) + 1);

        if(nextBlock > totalPageCnt) { this.nextBlock = totalPageCnt; }

        setStartIndex((page - 1) * postPerPage);
    }
}
