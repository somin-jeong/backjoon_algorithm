import java.util.ArrayList;

class Solution {
    public static int[] solution(String s) {
		String substring = s.substring(1, s.length() - 1).replace("},", "&").replace("{", "a");
		String[] splitStrings = substring.split("&a");

		ArrayList<int[]> list = new ArrayList<>();
		for (String splitString : splitStrings) {
			String replaceString = splitString.replace("a", "").replace("}", "");

			String[] stringArr = replaceString.split(",");
			int[] intArr = new int[stringArr.length];
			for (int i = 0; i < stringArr.length; i++) {
				intArr[i] = Integer.parseInt(stringArr[i]);
			}
			list.add(intArr);
		}

		list.sort((o1, o2) -> {
			if (o1.length < o2.length)
				return -1;
			else if (o1.length > o2.length)
				return 1;
			else
				return 0;
		});

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int[] nums = list.get(i);
			for (int j = 0; j < nums.length; j++) {
				if (!result.contains(nums[j])) {
					result.add(nums[j]);
				}
			}
		}

		int[] answer = result.stream().mapToInt(i -> i).toArray();
		return answer;
	}
}