package exercise;

// BEGIN
class ReversedSequence implements CharSequence{
    String sequence;
    ReversedSequence(String s) {
        char[] array = s.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        this.sequence = result;
    }

    @Override
    public int length() {
        return this.sequence.length();
    }

    @Override
    public char charAt(int index) {
        return this.sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.sequence.subSequence(start,end);
    }

    @Override
    public String toString() {
        return this.sequence;
    }
}
// END
