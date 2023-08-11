Default (GPT-3.5)

User
async function main() {
    console.log("Fetch initiated!");

    const url = "https://opentdb.com/api.php?amount=10&category=31&difficulty=medium&type=multiple";

    try {
       const response = await fetch(url);


       console.log(response);

       console.log(`response ok? ${response.ok}`);
       console.log(`response status? ${response.status}`);

       if(!response.ok){
        throw new Error(`something went wrong with ${response.status}.`);
       }

       const json = await response.json();
       const { response_code, results} = json;

       if(response_code === 1) {
            throw new Error('Bad API request - no results! ');
       } else if (response_code === 2) {
        throw new Error('BAD API rquest - invalid parameter!');
       }

       console.log(json);
        results.forEach((triviaItem,index) => {
            const {question, difficulty, correct_answer} = triviaItem;
            console.log(`
           Question number: ${index + 1}
           Difficulty:  ${difficulty}
           Question : ${question}
           ${correct_answer}`);
        });


        const main = document.querySelector("main");
        results.forEach((triviaItem) => {
            main.insertAdjacentHTML("beforeend", `<p>${triviaItem.question}</p>`);
        });

    } catch (err) {
        console.log("An error occurred.");
        console.error(err);
    }
}

main();  

   