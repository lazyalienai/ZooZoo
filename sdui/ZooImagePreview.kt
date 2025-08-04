@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ZooImagePreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_test_image),
            contentDescription = "Test Image",
            modifier = Modifier,
        )
    }
}