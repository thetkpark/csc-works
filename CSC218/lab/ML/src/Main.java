public class Main {

    public static void main(String[] args) {
	    String trainingFile = "creditRisk_Clean_NoCreditHistory_training.arff";
	    String testingFile = "creditRisk_Clean_NoCreditHistory_testing.arff";
	    String PredictFile = "predict.arff";

	    LoanML loan = new LoanML(9, trainingFile, testingFile, PredictFile);
		loan.trainAndTestDataSet();
    }
}
