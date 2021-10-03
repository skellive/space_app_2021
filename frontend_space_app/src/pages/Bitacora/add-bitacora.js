import React from 'react';
import MenuEditor from '../../components/MenuEditor'
import { Container,Row,Col,Card } from 'reactstrap';
import { useEditor, EditorContent } from '@tiptap/react';
import StarterKit from '@tiptap/starter-kit'
const AddBitacora = () => {
    const editor = useEditor({
        extensions: [
          StarterKit,
        ],
        content: '<p>Hello World! 🌎️</p>',
      })
  return (
    <Container className="mt--7" fluid>
        <Row>
          <Col md="12">
            <Card className="card-stats mb-4 mb-lg-0">
              
                <MenuEditor
                  editor={editor}
                />
                <EditorContent
                  editor={editor}

                />
            </Card>
          </Col>
        </Row>
      </Container>
    
  );
}
export default AddBitacora;