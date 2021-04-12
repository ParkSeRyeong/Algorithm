package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_20187_종이접기 {

	private static class paper {
		int dir;
		// 작으면 false, 크면 true임.
		boolean row;
		boolean col;

		public paper() {
		}

		public paper(int dir, boolean row, boolean col) {
			this.dir = dir;
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "방향 : "+dir+" / row가 큰가? : "+row+" / col이 큰가? : "+col+"\n";
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/study/종이접기_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int size=(int) Math.pow(2, K);
		String[] info = br.readLine().split(" ");
		int punch=Integer.parseInt(br.readLine());

		int[][] swap = { { 1, 2 }, { 0, 3 }, { 3, 0 }, { 2, 1 } };
		// --------------------------------------------------------------------------
		// 1. 방향 정보, row 정보, col정보 담을 list.
		// 메모리가 걱정됨.

		ArrayList<ArrayList<paper>> list = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			list.add(new ArrayList<>());
			// 1. 왼쪽 위 : row, col 둘 다 작음
			for (int j = 0; j < size; j++) {
				list.get(i).add((new paper(0, false, false)));
			}
			// 오른쪽 위 : col만 큼
			for (int j = size; j < size * 2; j++) {
				list.get(i).add((new paper(0, false, true)));
			}
			System.out.println(i+"줄 끝");
		}
		for (int i =size; i < size * 2; i++) {
			list.add(new ArrayList<>());
			// 왼쪽 아래 : row만 큼
			for (int j = 0; j < size; j++) {
				list.get(i).add((new paper(0, true, false)));
			}
			// 오른쪽 아래 : row, col 둘 다 큼
			for (int j = size; j < size * 2; j++) {
				list.get(i).add((new paper(0, true, true)));
			}
			System.out.println(i+"줄 끝");
		}
		// --------------------------------------------------------------------------
		for(ArrayList<paper> i:list) {
			System.out.println(i);
		}
		// --------------------------------------------------------------------------

		for (String s : info) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size(); j++) {
					int dir = list.get(i).get(j).dir;
					boolean bRow = list.get(i).get(j).row;
					boolean bCol = list.get(i).get(j).col;

					// COL 작고 커지는거 다시 생각해야됨
					switch(s) {
					case "R":
						if(!bCol) {
							System.out.printf("(%d,%d)에 R들어왔어용\n",i,j);
							System.out.printf("\t(%d,%d) 방향 : %d -> %d\n",i,j,dir,swap[dir][0]);
							list.get(i).get(j).dir=swap[dir][0];
						}
						break;
					case "L":
						if(bCol) {
							System.out.printf("(%d,%d)에 L들어왔어용\n",i,j);
							System.out.printf("\t(%d,%d) 방향 : %d -> %d\n",i,j,dir,swap[dir][0]);
							list.get(i).get(j).dir=swap[dir][0];
						}
						break;
					case "D":
						if(!bRow) {
							System.out.printf("(%d,%d)에 D들어왔어용\n",i,j);
							System.out.printf("\t(%d,%d) 방향 : %d -> %d\n",i,j,dir,swap[dir][1]);
							list.get(i).get(j).dir=swap[dir][1];
						}
						break;
					case "U":
						if(bRow) {
							System.out.printf("(%d,%d)에 U들어왔어용\n",i,j);
							System.out.printf("\t(%d,%d) 방향 : %d -> %d\n",i,j,dir,swap[dir][1]);
							list.get(i).get(j).dir=swap[dir][1];
						}
						break;
							
					}
				}
			}
		}
		System.out.println(list.get(0).get(1));
	}
}
