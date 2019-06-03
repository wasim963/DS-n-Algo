public class HuffmanClient {

	public static void main(String[] args) {
		// HuffmanCoding hc=new HuffmanCoding("");
		HuffmanCoding hc = new HuffmanCoding("cdaabbbbeee");
		System.out.println(hc.Encoding("edcba"));
		System.out.println();
		System.out.println(hc.Encoding("abcde"));
		System.out.println(hc.Decoding("01010101011111000100010000001"));
	}

}
