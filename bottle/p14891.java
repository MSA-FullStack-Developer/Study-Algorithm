import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p14891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();

        String s1 = br.readLine();
        for (int i = 0; i < s1.length(); i++) {
            String c1 = s1.substring(i, i + 1);
            list1.add(c1);
        }
        String s2 = br.readLine();
        for (int i = 0; i < s2.length(); i++) {
            String c2 = s2.substring(i, i + 1);
            list2.add(c2);
        }
        String s3 = br.readLine();
        for (int i = 0; i < s3.length(); i++) {
            String c3 = s3.substring(i, i + 1);
            list3.add(c3);
        }
        String s4 = br.readLine();
        for (int i = 0; i < s4.length(); i++) {
            String c4 = s4.substring(i, i + 1);
            list4.add(c4);
        }

        String wheel_num = "";
        String direction = "";
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wheel_num = st.nextToken();
            direction = st.nextToken();

            if (wheel_num.equals("1")) {
                if (direction.equals("-1")) {
                    // list1 반시계 방향이동
                    if (!list1.get(2).equals(list2.get(6))) {
                        if (!list2.get(2).equals(list3.get(6))) {
                            if (!list3.get(2).equals(list4.get(6))) {
                                // list4 시계방향 이동
                                list4.add(0, list4.get(7));
                                list4.remove(8);
                            }
                            // list3 반시계방향 이동
                            list3.add(list3.get(0));
                            list3.remove(0);
                        }
                        // list2 시계방향 이동
                        list2.add(0, list2.get(7));
                        list2.remove(8);
                    }
                    // list1 최종 반시계방향 이동
                    list1.add(list1.get(0));
                    list1.remove(0);
                } else if (direction.equals("1")) {
                    // list1 시계방향 이동

                    if (!list1.get(2).equals(list2.get(6))) {
                        if (!list2.get(2).equals(list3.get(6))) {
                            if (!list3.get(2).equals(list4.get(6))) {
                                // list4 반시계방향으로 이동
                                list4.add(list4.get(0));
                                list4.remove(0);
                            }
                            // list3 시계방향 이동
                            list3.add(0, list3.get(7));
                            list3.remove(8);
                        }
                        // list2 반시계방향 이동
                        list2.add(list2.get(0));
                        list2.remove(0);
                    }
                    // list1 최종 시계방향 이동
                    list1.add(0, list1.get(7));
                    list1.remove(8);
                }
            } else if (wheel_num.equals("2")) {
                if (direction.equals("-1")) {
                    if (!list2.get(6).equals(list1.get(2))) {
                        // list1 시계방향 이동
                        list1.add(0, list1.get(7));
                        list1.remove(8);
                    }
                    if (!list2.get(2).equals(list3.get(6))) {
                        if (!list3.get(2).equals(list4.get(6))) {
                            list4.add(list4.get(0));
                            list4.remove(0);
                            // list4 반시계방향 회전
                        }
                        // list3 시계방향 회전
                        list3.add(0, list3.get(7));
                        list3.remove(8);
                    }
                    // list2 최종 반시계방향 회전
                    list2.add(list2.get(0));
                    list2.remove(0);
                } else if (direction.equals("1")) {
                    // list2 시계방향 이동
                    if (!list2.get(6).equals(list1.get(2))) {
                        // list1 반시계 방향 이동
                        list1.add(list1.get(0));
                        list1.remove(0);
                    }
                    if (!list2.get(2).equals(list3.get(6))) {
                        if (!list3.get(2).equals(list4.get(6))) {
                            // list4 시계방향 이동
                            list4.add(0, list4.get(7));
                            list4.remove(8);
                        }
                        // list3 반시계 방향 이동
                        list3.add(list3.get(0));
                        list3.remove(0);
                    }
                    // list2 최종 시계방향 이동
                    list2.add(0, list2.get(7));
                    list2.remove(8);
                }
            } else if (wheel_num.equals("3")) {
                // list3이 반시계 방향 회전일 때
                if (direction.equals("-1")) {
                    if (!list3.get(2).equals(list4.get(6))) {
                        // list4 시계방향 회전
                        list4.add(0, list4.get(7));
                        list4.remove(8);

                    }
                    if (!list3.get(6).equals(list2.get(2))) {
                        if (!list2.get(6).equals(list1.get(2))) {
                            // list1 반시계방향 회전
                            list1.add(list1.get(0));
                            list1.remove(0);
                        }
                        // list2 시계방향 회전
                        list2.add(0, list2.get(7));
                        list2.remove(8);
                    }
                    // 최종 list3 반시계 방향 회전

                    list3.add(list3.get(0));
                    list3.remove(0);
                } else if (direction.equals("1")) {
                    if (!list3.get(2).equals(list4.get(6))) {
                        // list4 반시계 방향 이동
                        list4.add(list4.get(0));
                        list4.remove(0);
                    }
                    if (!list3.get(6).equals(list2.get(2))) {
                        if (!list2.get(6).equals(list1.get(2))) {
                            // list1 시계방향 이동
                            list1.add(0, list1.get(7));
                            list1.remove(8);
                        }
                        // list2 반시계 방향 이동
                        list2.add(list2.get(0));
                        list2.remove(0);
                    }
                    // list3 최종 시계방향 회전
                    list3.add(0, list3.get(7));
                    list3.remove(8);
                }
            } else if (wheel_num.equals("4")) {
                if (direction.equals("-1")) {
                    if (!list4.get(6).equals(list3.get(2))) {
                        if (!list3.get(6).equals(list2.get(2))) {
                            if (!list2.get(6).equals(list1.get(2))) {
                                // list1 시계방향 이동
                                list1.add(0, list1.get(7));
                                list1.remove(list1.get(8));
                            }
                            // list2 반시계방향 이동
                            list2.add(list2.get(0));
                            list2.remove(0);
                        }
                        // list3 시계방향 이동
                        list3.add(0, list3.get(7));
                        list3.remove(list3.get(8));
                    }
                    // 최종 list4 반시계방향 이동
                    list4.add(list4.get(0));
                    list4.remove(0);
                } else if (direction.equals("1")) {

                    if (!list4.get(6).equals(list3.get(2))) {
                        if (!list3.get(6).equals(list2.get(2))) {
                            if (!list2.get(6).equals(list1.get(2))) {
                                // list1 반시계방향 이동
                                list1.add(list1.get(0));
                                list1.remove(0);
                            }
                            // list2 시계방향 이동

                            list2.add(0, list2.get(7));
                            list2.remove(8);
                        }
                        // list3 반시계방향 이동
                        list3.add(list3.get(0));
                        list3.remove(0);
                    }
                    // list4 최종 시계방향 회전
                    list4.add(0, list4.get(7));
                    list4.remove(8);
                }
            }
        }

        int sum = 0;
        if (list1.get(0).equals("1")) {
            sum += 1;
        }
        if (list2.get(0).equals("1")) {
            sum += 2;
        }
        if (list3.get(0).equals("1")) {
            sum += 4;
        }
        if (list4.get(0).equals("1")) {
            sum += 8;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
