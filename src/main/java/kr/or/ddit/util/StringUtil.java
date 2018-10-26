package kr.or.ddit.util;

public class StringUtil {
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : Bella
	* 변경이력 :
	* @param contentDisposition
	* @return 경로 문자열에서 파일 이름만 반환
	* Method 설명 : contentDisposition에서 filename을 추출
	*/
	public static String getFileNameFromHeader(String contentDisposition){
		
		String fileName = "";
		String[] split = contentDisposition.split("; ");
		for (String str : split) {
			if (str.indexOf("filename=") >= 0) {
				int beginIndex = str.indexOf("filename=") + 10;
				int endIndex = str.lastIndexOf("\"");
				fileName = str.substring(beginIndex, endIndex);
			}
		}
		return fileName;
	}
	
	
	

}





































