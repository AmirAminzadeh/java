package com.senecacollege.workshop4.Task2.java;

import java.io.FileInputStream;
import java.io.IOException;

public class Util {

	// This method is for placing each capital letter and small letter with its
	// ASCII code
	public static void letterCounter(int[] AtoZCapital, int[] aTozSmall, FileInputStream fis) throws IOException {

		int c;
		while ((c = fis.read()) != -1) {
			switch (c) {
			case 65:
				AtoZCapital[0]++;
				break;
			case 66:
				AtoZCapital[1]++;
				break;
			case 67:
				AtoZCapital[2]++;
				break;
			case 68:
				AtoZCapital[3]++;
				break;
			case 69:
				AtoZCapital[4]++;
				break;
			case 70:
				AtoZCapital[5]++;
				break;
			case 71:
				AtoZCapital[6]++;
				break;
			case 72:
				AtoZCapital[7]++;
				break;
			case 73:
				AtoZCapital[8]++;
				break;
			case 74:
				AtoZCapital[9]++;
				break;
			case 75:
				AtoZCapital[10]++;
				break;
			case 76:
				AtoZCapital[11]++;
				break;
			case 77:
				AtoZCapital[12]++;
				break;
			case 78:
				AtoZCapital[13]++;
				break;
			case 79:
				AtoZCapital[14]++;
				break;
			case 80:
				AtoZCapital[15]++;
				break;
			case 81:
				AtoZCapital[16]++;
				break;
			case 82:
				AtoZCapital[17]++;
				break;
			case 83:
				AtoZCapital[18]++;
				break;
			case 84:
				AtoZCapital[19]++;
				break;
			case 85:
				AtoZCapital[20]++;
				break;
			case 86:
				AtoZCapital[21]++;
				break;
			case 87:
				AtoZCapital[22]++;
				break;
			case 88:
				AtoZCapital[23]++;
				break;
			case 89:
				AtoZCapital[24]++;
				break;
			case 90:
				AtoZCapital[25]++;
				break;
			////////////////////////////////////////////
			case 97:
				aTozSmall[0]++;
				break;
			case 98:
				aTozSmall[1]++;
				break;
			case 99:
				aTozSmall[2]++;
				break;
			case 100:
				aTozSmall[3]++;
				break;
			case 101:
				aTozSmall[4]++;
				break;
			case 102:
				aTozSmall[5]++;
				break;
			case 103:
				aTozSmall[6]++;
				break;
			case 104:
				aTozSmall[7]++;
				break;
			case 105:
				aTozSmall[8]++;
				break;
			case 106:
				aTozSmall[9]++;
				break;
			case 107:
				aTozSmall[10]++;
				break;
			case 108:
				aTozSmall[11]++;
				break;
			case 109:
				aTozSmall[12]++;
				break;
			case 110:
				aTozSmall[13]++;
				break;
			case 111:
				aTozSmall[14]++;
				break;
			case 112:
				aTozSmall[15]++;
				break;
			case 113:
				aTozSmall[16]++;
				break;
			case 114:
				aTozSmall[17]++;
				break;
			case 115:
				aTozSmall[18]++;
				break;
			case 116:
				aTozSmall[19]++;
				break;
			case 117:
				aTozSmall[20]++;
				break;
			case 118:
				aTozSmall[21]++;
				break;
			case 119:
				aTozSmall[22]++;
				break;
			case 120:
				aTozSmall[23]++;
				break;
			case 121:
				aTozSmall[24]++;
				break;
			case 122:
				aTozSmall[25]++;
				break;
			}
		}
	}
}
