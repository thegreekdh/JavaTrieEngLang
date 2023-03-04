Simple Java string trie implementation for fast lookup.

The structure is as follows:

![Image](/demo/trie.png)

This stores the valid English words A, AN, ANGER, and ANGLE.
Here, * is the root node, and @ nodes are valid end paths through the tree (meaning, valid English words).
Each node consists of a single letter or a special character.


These structures can be used for fast prefix lookups with applications in, for example, autocompletion, predictive text, and sorting.