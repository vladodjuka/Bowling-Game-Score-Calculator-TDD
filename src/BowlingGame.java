/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student:
 * @version 1.0
 * @date 2016-11-24
 */

public class BowlingGame {
	private String game;

	/**
	 * BowlingGame Score calculator constructor which require string as input
	 * 
	 * @param game
	 *            Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */
	public BowlingGame(String game) {
		if (game != null) {
			this.game = game;
		} else {
			this.game = "";
		}
		// TODO:create constructor for BowlingGame
	}

	public BowlingGame() {

	}

	/**
	 * getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is
	 *         -1
	 */
	public int getScore() {
		int score = 0;
		if (!this.game.equals("")) {
			if (this.game.indexOf("[") != 0 || this.game.lastIndexOf("]") != (this.game.length() - 1)) {
				return -1;
			}
			String removeCharacter = this.game.substring(1, this.game.length() - 1);
			removeCharacter = removeCharacter.replaceAll("\\]\\[", ";");
			String array[] = removeCharacter.split(";");
			if (array.length < 10 || array.length > 11) {
				return -1;
			} else {
				for (int i = 0; i < array.length; i++) {
					if (array[i].indexOf(",") == -1 && i != 10) {
						return -1;
					}

					String newArray[] = array[i].split(",");

					for (int j = 0; j < newArray.length; j++) {
						if (newArray[j].trim().equals("")) {
							return -1;
						}

						if (i == 9 && j == 0 && newArray[j].matches("\\d*") && newArray[j + 1].matches("\\d*")
								&& (Integer.parseInt(newArray[j]) + Integer.parseInt(newArray[j + 1]) != 10
										&& array.length > 10)) {
							return -1;
						}

						if (j == 0 && i!=10 && newArray[j].matches("\\d*") && newArray[j + 1].matches("\\d*")
								&& (Integer.parseInt(newArray[j]) + Integer.parseInt(newArray[j + 1]) > 10)) {
							return -1;
						}

						// STRIKE
						if (j == 0 && newArray[j].equals("10") && i < 9) {
							if (!newArray[1].equals("0")) {
								return -1;
							}

							String strikeArray[] = array[i + 1].split(",");

							if (strikeArray[0].equals("10")) {

								score += Integer.parseInt(strikeArray[0]);

								String strikeArray2[] = array[i + 2].split(",");

								if (strikeArray2[0].matches("\\d*")) {
									score += Integer.parseInt(strikeArray2[0]);

								} else {
									return -1;
								}

							} else {
								for (int j2 = 0; j2 < strikeArray.length; j2++) {
									if (strikeArray[j2].matches("\\d*")) {
										score += Integer.parseInt(strikeArray[j2]);
									} else {
										return -1;
									}
								}
							}

						} else {
							if (newArray[0].equals("10") && i == 9) {
								if (array.length != 11) {
									return -1;
								}
							}
						}
						// SPARE
						if (!newArray[0].equals("10") && i != 10 && i != 9 && j == 0 && newArray[j + 1].matches("\\d*")
								&& (Integer.parseInt(newArray[j]) + Integer.parseInt(newArray[j + 1])) == 10) {
							String spareArray[] = array[i + 1].split(",");
							if (spareArray[0].matches("\\d*")) {
								score += Integer.parseInt(spareArray[0]);
							} else {
								return -1;
							}
						} else {
							if (!newArray[0].equals("10") && i == 9 && j == 0 && newArray[j + 1].matches("\\d*")
									&& (Integer.parseInt(newArray[j]) + Integer.parseInt(newArray[j + 1])) == 10) {
								if (array.length != 11) {
									return -1;
								}
								if (array.length == 11 && array[i + 1].indexOf(",") != -1) {
									return -1;
								}
							}
						}

						// OPEN FRAME
						if (newArray[j].matches("\\d*")) {
							score += Integer.parseInt(newArray[j]);
						} else {
							return -1;
						}

					}

				}

				return score;
			}
		}

		return -1;

	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

}
