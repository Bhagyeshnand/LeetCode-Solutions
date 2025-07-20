class Solution {
    private static class Node {
		private String val;
		private boolean duplicate;
		private Map<String, Node> children;

		public Node(String val) {
			this.val = val;
			this.duplicate = false;
			this.children = new TreeMap<String, Node>();
		}
	}

	private Node root = new Node("/");

	private String postOrder(Node curr, Map<String, Node> map) {
		StringBuffer sb = new StringBuffer();
		for (Node child : curr.children.values()) {
			sb.append(postOrder(child, map));
			sb.append(",");
		}

		String key = sb.toString();
		if (sb.length() == 0) {
			return curr.val + key; // leaf node
		}
		if (map.containsKey(key)) {
			Node orig = map.get(key);
			orig.duplicate = true;
			curr.duplicate = true;
		} else {
			map.put(key, curr);
		}

		return curr.val + "(" + key + ")";
	}

	private void inOrder(List<List<String>> ans, Node node, List<String> list) {
		if (node == null) {
			return;
		}
		for (Node child : node.children.values()) {
			if (child.duplicate) {
				continue;
			}
			list.add(child.val);
			ans.add(new ArrayList<>(list));
			inOrder(ans, child, list);
			list.remove(list.size() - 1);
		}
	}

	private void insertPath(List<String> path) {
		Node curr = this.root;
		for (String folder : path) {
			if (!curr.children.containsKey(folder)) {
				curr.children.put(folder, new Node(folder));

			}
			curr = curr.children.get(folder);
		}
	}

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths) {
			insertPath(path);
		}
		Map<String, Node> map = new HashMap<>();
		postOrder(this.root, map);
		List<List<String>> ans = new ArrayList<>();
		inOrder(ans, this.root, new ArrayList<String>());
		return ans;
    }
}