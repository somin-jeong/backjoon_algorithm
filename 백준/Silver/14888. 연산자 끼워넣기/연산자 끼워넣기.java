import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	public static int operandCount;
	public static List<Integer> operandList = new ArrayList<>();
	public static List<String> operator = new ArrayList<>();
	public static int min = 1000000000;
	public static int max = -1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		operandCount = Integer.parseInt(br.readLine());
		String operand = br.readLine();
		StringTokenizer st = new StringTokenizer(operand, " ");
		for (int i = 0; i < operandCount; i++) {
			operandList.add(Integer.parseInt(st.nextToken()));
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		Map<String, Integer> map = new HashMap<>();
		map.put("+", Integer.parseInt(st2.nextToken()));
		map.put("-", Integer.parseInt(st2.nextToken()));
		map.put("*", Integer.parseInt(st2.nextToken()));
		map.put("%", Integer.parseInt(st2.nextToken()));

		operator.add("+");
		operator.add("-");
		operator.add("*");
		operator.add("%");

		String[] arr = new String[operandCount];
		dfs(0, arr, map);

		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}

	public static void dfs(int depth, String[] arr, Map<String, Integer> map) {
		if (depth == operandCount-1) {
			int result = operandList.get(0);
			for (int i = 0; i < operandCount-1; i++) {
				result = calculate(arr[i], result, operandList.get(i+1));
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (map.get(operator.get(i)) != 0) {
				map.put(operator.get(i), map.get(operator.get(i))-1);
				arr[depth]=operator.get(i);
				dfs(depth+1, arr, map);
				map.put(operator.get(i), map.get(operator.get(i))+1);
			}
		}
	}

	public static int calculate(String operator, Integer operand1, Integer operand2) {
		if (Objects.equals(operator, "+")) {
			return operand1 + operand2;
		} else if (Objects.equals(operator, "-")) {
			return operand1 - operand2;
		} else if (Objects.equals(operator, "*")) {
			return operand1 * operand2;
		} else if (Objects.equals(operator, "%")) {
			return operand1 / operand2;
		}
		return 0;
	}
}