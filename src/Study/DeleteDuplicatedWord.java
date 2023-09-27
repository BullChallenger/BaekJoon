package Study;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class DeleteDuplicatedWord {

        public static void main(String[] args) throws IOException {
            solution();
        }

        private static void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder builder = new StringBuilder();
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (input.indexOf(ch) == i) {
                    builder.append(ch);
                }
            }

            System.out.println(builder);
        }
    }
