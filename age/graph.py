

class Graph():
    def __init__(self, stmt=None) -> None:
        self.statement = stmt
        self.rows = list()

    def __iter__(self):
        return self.rows.__iter__()

    def __len__(self):
        return self.rows.__len__()

    def append(self, row):
        self.rows.append(row)
