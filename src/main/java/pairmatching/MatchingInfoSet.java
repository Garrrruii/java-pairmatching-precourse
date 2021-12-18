package pairmatching;

import java.util.HashMap;

public class MatchingInfoSet {
    public static class MatchingKey {
        public Course course;
        public String mission;

        public MatchingKey(Course course, String mission) {
            this.course = course;
            this.mission = mission;
        }

        public boolean isBackend() {
            if (course == Course.BACKEND) {
                return true;
            }
            return false;
        }
    }

    private HashMap<String, MatchingInfo> allMatchingInfo = new HashMap<>();

    public MatchingInfoSet() {}

    public void performPairMatching(String matchKey) {
        MatchingInfo info = new MatchingInfo();
        if (allMatchingInfo.containsKey(matchKey)) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            boolean rematch = InputManager.getAnswer();
            if (!rematch) {
                return;
            }
            info = allMatchingInfo.get(matchKey);
        }
        info.match(isBackend(matchKey));
        allMatchingInfo.put(matchKey, info);
    }

    public void viewPairMatching(String matchKey) {
        if (allMatchingInfo.containsKey(matchKey)) {
            allMatchingInfo.get(matchKey).view();
            return;
        }
        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }

    public void initializeAllPairMatching() {
        allMatchingInfo.clear();
    }

    private boolean isBackend(String matchKey){
        if(InputManager.isBackend(matchKey)){
            return true;
        }
        return false;
    }


}
