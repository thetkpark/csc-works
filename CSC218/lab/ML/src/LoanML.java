import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class LoanML {
    Classifier classifier;
    int classAttribute;
    String trainFile, testFile, predictFile;
    String pmmlLoanModel;

    public LoanML (int classAttribute, String trainFile, String testFile, String predictFile) {
        this.classAttribute = classAttribute;
        this.trainFile = trainFile;
        this.testFile = testFile;
        this.predictFile = predictFile;
    }

    public Instances getData(String fileName, int classAtt){
        try {
            ArffLoader loader = new ArffLoader();
            loader.setFile(new File(fileName));
            Instances dataSet = loader.getDataSet();
            dataSet.setClassIndex(classAtt);
            return dataSet;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void trainAndTestDataSet(){
        try {
            Instances trainingDataSet = getData(trainFile, classAttribute);
            classifier = new Logistic();
            classifier.buildClassifier(trainingDataSet);
            System.out.println(classifier);

            Instances testingDataSet = getData(testFile, classAttribute);
            Evaluation eval = new Evaluation(trainingDataSet);
            eval.evaluateModel(classifier, testingDataSet);
            System.out.println(eval.toSummaryString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void predictDataSet (){
        System.out.println("Predict the output");
        Instance predictData;
        double answer = 0;
        Instances predictDataSets = getData(predictFile, classAttribute);
        for(int i=0; i<predictDataSets.numInstances(); i++){
            predictData = predictDataSets.instance(i);
            try {
                answer = classifier.classifyInstance(predictData);
                System.out.println(answer);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

