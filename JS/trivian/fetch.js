window.onload = function(){
    const url = "https://opentdb.com/api.php?amount=10&category=31&difficulty=medium&type=multiple";

    fetch(url).then(function(response){
        return response.json();
    }).then(main).catch(function(err) {
        console.log('Gosto muito de ES6 também, mas só há disso amanhã')
    });
}


// Define an async function named main


function main(json) {

        const { response_code, results } = json;
        //amezin districturin


        // Handle different response codes
        if (response_code === 1) {
            throw new Error('Bad API request - no results! ');
        } else if (response_code === 2) {
            throw new Error('BAD API request - invalid parameter!');
        }


        // Log the parsed JSON data
        console.log(json);


        // Get the "main" element from the document
        const main = document.querySelector("main");


        // Initialize the index for the current question
        let currentQuestionIndex = 0;



        function displayQuestion() {


            // Get the current trivia item
            const triviaItem = results[currentQuestionIndex];
            const { question, difficulty, correct_answer, incorrect_answers } = triviaItem;


            // Shuffle the answer options randomly
            //I love spread operators................
            const allOptions = [correct_answer, ...incorrect_answers];
            allOptions.sort(() => Math.random() - 0.5);


            // Create a container for the question form
            const questionContainer = document.createElement("div");
            questionContainer.classList.add("question-container");


            // Create a form with buttons for each option
            const form = document.createElement("form");

            //innerHTML é utilizado para preencher o conteudo do formulário
            //map vai percorrer o array de allOptions 
            //depois o join vai concatenar o cóidgo de numa única string
            form.innerHTML = `
                <p>Question number: ${currentQuestionIndex + 1}</p>
                <p>Difficulty: ${difficulty}</p>
                <p>Question: ${question}</p>
                ${allOptions.map((option) =>  `
                    <label>
                        <input type="radio" name="userAnswer" value="${option}" />
                        <span class="custom-radio"></span>
                        ${option}
                    </label>
                    <br />
                `).join("")}
                <button type="submit">Submit Answer</button>
                <p>Correct Answer: ${correct_answer}</p>
            `;

            

            // vai adicionar conteudo intruzido ao forumlário
            form.addEventListener("submit", (event) => {

                //vai empedir  o comportamento do evento submit
                event.preventDefault();
                const userAnswer = form.querySelector("input[name='userAnswer']:checked");
                if (userAnswer) {
                    //  user's answer with the correct_answer
                    const selectedOption = userAnswer.value;
                    if (selectedOption === correct_answer) {
                        userAnswer.parentElement.classList.add("correct");
                        // Move to the next question or display completion message
                        currentQuestionIndex++;
                        if (currentQuestionIndex < results.length) {
                            main.innerHTML = "";
                            displayQuestion();
                        } else {
                            main.innerHTML = "<p>All questions completed!</p>";
                        }
                    } else {
                        userAnswer.parentElement.classList.add("wrong");
                    }
                } 
            });


            // Append form to the question container and then to the main element
            questionContainer.appendChild(form);
            main.appendChild(questionContainer);
        }


        // Call the displayQuestion function to start showing questions
        displayQuestion();


}

