pipeline
{
    agent any

    tools{
    	maven 'maven'
        }

    stages
    {
        stage('Build')
        {
            steps
            {
                 git 'https://github.com/balasivarathri/playwrightwithjava.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }

        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/balasivarathri/playwrightwithjava.git'
                    bat "mvn clean install"

                }
            }
        }

        stage('Publish HTML Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'cucumber-html-reports',
                                  reportFiles: 'overview-features.html',
                                  reportName: 'HTML Report',
                                  reportTitles: ''])
            }
        }
    }
}