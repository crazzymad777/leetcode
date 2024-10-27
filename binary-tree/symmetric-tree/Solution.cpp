class Solution {
public:
    bool isSymmetricSides(TreeNode* left, TreeNode* right) {
        if (left == nullptr && right == nullptr) {
            return true;
        }
        if (left == nullptr || right == nullptr) {
            return false;
        }
        if (left->val != right->val) {
            return false;
        }

        return isSymmetricSides(left->left, right->right) && isSymmetricSides(right->left, left->right);
    }

    bool isSymmetric(TreeNode* root) {
        return isSymmetricSides(root->left, root->right);
    }
};

