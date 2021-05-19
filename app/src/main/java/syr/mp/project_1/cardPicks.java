package syr.mp.project_1;

public class cardPicks {
    private Integer p1=0;
    private Integer p2=0;
    private Integer matches=0;
    private String tag1;
    private String tag2;
    private int ivId1;
    private int ivId2;


    public int getIvId1() {
        return ivId1;
    }

    public void setIvId1(int ivId1) {
        this.ivId1 = ivId1;
    }

    public int getIvId2() {
        return ivId2;
    }

    public void setIvId2(int ivId2) {
        this.ivId2 = ivId2;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public Integer getTries() {
        return tries;
    }

    public void setTries(Integer tries) {
        this.tries = tries;
    }

    private Integer tries=0;

    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    public Integer getP2() {
        return p2;
    }

    public void setP2(Integer p2) {
        this.p2 = p2;
    }
    public void setMatches(Integer matchesCount){
        this.matches=matchesCount;
    }
    public Integer getMatches(){
        return matches;
    }

    public void reset() {
        this.p1 =0;
        this.p2 =0;
    }
    public void resetTags(){
        this.tag1=null;
        this.tag2=null;
        this.ivId1=0;
        this.ivId2=0;


    }
}
