import random


class Game:
    def __init__(self, file_name='words.txt', total_guesses=6):
        self.words_file = file_name
        self.words = list(map(str.rstrip, open(file_name, 'r').readlines()))
        self.answer = self.pick_answer()
        self.guesses_remaining = total_guesses

    def play(self):
        state = (set(), set(), ["", "", "", "", ""])
        # loop until end of game
        while True:
            ret = self.get_guess(state)

            if ret == 0:  # win condition
                print(f"Congratulations, you correctly identified the word after {6 - self.guesses_remaining} attempts")
                break
            elif ret == -1:  # lose condition
                print(f"The answer is {self.answer}")
                break
            else:  # game not over condition
                state = ret
                print(f"Good Letters {list(ret[0])}")
                print(f"Bad Letters {list(ret[1])}")
                print(f"Correct Letters {ret[2]}")

    def pick_answer(self):
        # pick a random word from the list of valid words
        random_index = random.randint(0, len(self.words) - 1)
        write_fp = open('answer.txt', 'w')
        write_fp.write(self.words[random_index])
        return self.words[random_index]

    def get_guess(self, state):
        good, bad, correct = state

        # get user input
        while True:
            guess = input(f"Guess a word (you have {self.guesses_remaining} guesses remaining): ").upper()

            if guess not in self.words:
                print("Error: invalid input, try again.")
                continue
            break

        self.guesses_remaining -= 1

        # check win condition
        if guess == self.answer:
            return 0
        # check lose condition
        if guess != self.answer and self.guesses_remaining == 0:
            return -1
        # game not over condition
        for i, char in enumerate(guess):
            if char == self.answer[i]:
                correct[i] = char
            if char in self.answer:
                good.add(char)
            else:
                bad.add(char)

        return good, bad, correct


game = Game()
game.play()
